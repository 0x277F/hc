Hc Config File Specification
============================

##File Format
Hc configuration files are plain-text files. Both Unix and Windows line endings are supported.

##Philosophy
Hc aims for a strongly-typed config value. Values of definite type exist in either unqualified 
or qualified namespaces, each of which is also considered a value. The root document element is
considered an array. Each type available for use is designed to correspond to an existing Java
type or primitive.

##Preprocessor
All hc configuration files are preprocessed for several things.
1. Comments are C-style, with `//` representing a comment until the next newline, and `/*` and
`*/` representing opening and closing comments respectively.
2. Typedefs are specified with the `typedef` keyword. They are processed in no particular order
at this point. A `typedef` follows the same syntax as in C: `typedef <original type> <new type>;`.
Several typedefs exist at a global namespace for ease-of-use. Typedefs declared in one file are 
not shared in other files.

##Syntax
While the root element in an hc config is technically an array, it does not need to be notated 
as such.

1. Every config value may be qualified by a string.
2. Uninitialized values are not permitted.
3. Qualified config values are denoted as `<type>:<qualifier> = <value>`. For example, given a
`typedef` for the Java primitive `int` to `I`, the statement `I:TestValue = 1;` would denote an
integer value qualified as `TestValue` which is initialized to `1`.
4. Use of Java types is in the same form as a class descriptor as determined by the Java specification.
For example, the class `java.lang.String` would be denoted as `Ljava/lang/String;`.
5. Semicolons are necessary both at the end of declarations (and `typedef`s) and at the end of 
class descriptors as above. Note, however, they are not required to end an array declaration.
6. As with the Java specification, array types are prefixed with a `[`. Value statements for arrays
are comma-separated values enclosed in `{`curly braces`}`. The declaration `[I:TestValues = { 0, 1, 2 }`
denotes an array of three integers, for example.
7. One can have an array of declarations. This would take the form: 
```
[: DeclarationArray = { I:IntValue = 2, Ljava/lang/String;:StringValue = "test" }
```
This would specify an array of qualified values. Note the lack of a type qualifier on the `DeclarationArray`.
This applies for nested arrays as well:
```
[:OuterArray = { I:IntValue = 2, [Ljava/lang/String:StringArray = { "test", "abc" }, [:InnerArray = { I:IntValue2 = 5, I:IntValue3 = 65 } }
```
As you can see, this is rather cluttered. To fix this, array declarations can span multiple lines.
```
[:OuterArray = {
    I:IntValue = 2,
    [Ljava/lang/String:StringArray = {
        "test",
        "abc";
    },
    [:InnerArray = {
        I:IntValue2 = 5,
        I:IntValue3 = 65;
    };
}
```
This works invariably, but with one visible caveat. Semicolons must be placed on the last element
of each array element excluding the outermost when arrays are initialized on multiple lines. Note
that this includes a semicolon after the `}` at the end of the `InnerArray`.
8. Paths to a specific value which is nested in arrays are delimited with `.`
Therefore, in the above example, `IntValue3` would be fully qualified as `OuterArray.InnerArray.IntValue3`.
Fully qualifying values is not necessary unless there is a value with a duplicate name.