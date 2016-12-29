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
package lc.hex.hc.api.exception;

import lc.hex.hc.api.Configuration;

/**
 * Thrown if there is an easily-locatable syntax error in a given configuration.
 */
public class SyntaxException extends InvalidConfigurationException {
    private final int line;
    private final int col;

    public SyntaxException(Configuration config, int line, int col) {
        super(config);
        this.line = line;
        this.col = col;
    }

    public SyntaxException(Configuration config, String message, int line, int col) {
        super(config, message);
        this.line = line;
        this.col = col;
    }

    public SyntaxException(Configuration config, String message, Throwable cause, int line, int col) {
        super(config, message, cause);
        this.line = line;
        this.col = col;
    }

    public SyntaxException(Configuration config, Throwable cause, int line, int col) {
        super(config, cause);
        this.line = line;
        this.col = col;
    }

    public int getLine() {
        return line;
    }

    public int getCol() {
        return col;
    }
}
