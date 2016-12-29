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
 *
 */
package lc.hex.hc.api;

/**
 * Stores global-level typedefs.
 */
public final class Typedefs {
    public static final TypeTransformer I = TypeTransformer.of("I", "Ljava/lang/Integer");
    public static final TypeTransformer Z = TypeTransformer.of("Z", "Ljava/lang/Boolean");
    public static final TypeTransformer B = TypeTransformer.of("B", "Ljava/lang/Byte");
    public static final TypeTransformer C = TypeTransformer.of("C", "Ljava/lang/Character");
    public static final TypeTransformer D = TypeTransformer.of("D", "Ljava/lang/Double");
    public static final TypeTransformer F = TypeTransformer.of("F", "Ljava/lang/Float");
    public static final TypeTransformer J = TypeTransformer.of("J", "Ljava/lang/Long");
    public static final TypeTransformer H = TypeTransformer.of("H", "Ljava/lang/Short");
    public static final TypeTransformer S = TypeTransformer.of("S", "Ljava/lang/String;");

    private Typedefs() {
    }
}
