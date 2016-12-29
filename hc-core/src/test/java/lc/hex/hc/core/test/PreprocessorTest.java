/*
 * Copyright 2016 Hex <hex@hex.lc>
 * and other copyright owners as documented in the project's IP log.
 *
 * Licensed under the Apache License, Version 2.0 (the "License&quot￼;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lc.hex.hc.core.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import lc.hex.hc.api.TypeTransformer;
import lc.hex.hc.core.Preprocessor;

public class PreprocessorTest {
    @Test
    public void testLineComments() {
        List<String> lines = Arrays.asList(
                "Akkarin has a huge",
                "// It's not what you think!",
                "anime body pillow!"
        );
        Preprocessor preprocessor = new Preprocessor(lines);
        String test = preprocessor.preprocess();
        Assert.assertEquals("Akkarin has a hugeanime body pillow!", test);
    }

    @Test
    public void testComments() {
        List<String> lines = Arrays.asList(
                "Schnaps ist gut für Cholera/* ~ Akkarin",
                "abc",
                "test */ !");
        Preprocessor preprocessor = new Preprocessor(lines);
        String test = preprocessor.preprocess();
        Assert.assertEquals("Schnaps ist gut für Cholera !", test);
    }

    @Test
    public void testTypedefs() {
        List<String> lines = Arrays.asList(
                "typedef Ljava/lang/String S",
                "garbage text"
        );
        Preprocessor preprocessor = new Preprocessor(lines);
        String remaining = preprocessor.preprocess();
        Assert.assertEquals(remaining, "garbage text");
        Set<TypeTransformer> typedefs = preprocessor.getTypedefs();
        boolean test = true;
        typedefs.forEach(typedef -> {
            Assert.assertEquals("Ljava/lang/String", typedef.transform("S"));
        });
    }
}
