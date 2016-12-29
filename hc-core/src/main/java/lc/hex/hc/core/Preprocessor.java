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
package lc.hex.hc.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import lc.hex.hc.api.TypeTransformer;

public class Preprocessor {
    private static final Pattern COMMENT_PATTERN = Pattern.compile("/\\*(?>(?:(?>[^*]+)|\\*(?!/))*)\\*/");

    private final List<String> lines;
    private final Set<TypeTransformer> typedefs;

    public Preprocessor(List<String> lines) {
        this.lines = lines;
        this.typedefs = new HashSet<>();
    }

    public String preprocess() {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("//")) {
                continue;
            }
            if (line.startsWith("typedef")) {
                String[] split = line.split(" ");
                typedefs.add(TypeTransformer.of(split[1], split[2]));
            } else {
                sb.append(line);
            }
        }
        return COMMENT_PATTERN.matcher(sb.toString()).replaceAll("");
    }

    public Set<TypeTransformer> getTypedefs() {
        return typedefs;
    }
}
