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

import javax.annotation.Nonnull;

/**
 * Represents a typedef inside a config.
 */
@FunctionalInterface
public interface TypeTransformer {
    /**
     * Get the type referred to by the given typedef
     *
     * @param input the typedef
     * @return the original type
     */
    @Nonnull
    String transform(@Nonnull String input);

    /**
     * Construct a type transformer based on a rule.
     *
     * @param output the output to produce
     * @param input the input to recognize
     * @return a new TypeTransformer
     */
    @Nonnull
    static TypeTransformer of(@Nonnull String output, @Nonnull String input) {
        return i -> {
            if (i.equals(input)) {
                return output;
            }
            return i;
        };
    }
}
