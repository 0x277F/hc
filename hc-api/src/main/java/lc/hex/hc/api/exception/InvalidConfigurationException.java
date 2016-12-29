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
 * Thrown if a configuration is unable to be parsed correctly.
 */
public class InvalidConfigurationException extends RuntimeException {
    private final Configuration config;

    public InvalidConfigurationException(Configuration config) {
        super();
        this.config = config;
    }

    public InvalidConfigurationException(Configuration config, String message) {
        super(message);
        this.config = config;
    }

    public InvalidConfigurationException(Configuration config, String message, Throwable cause) {
        super(message, cause);
        this.config = config;
    }

    public InvalidConfigurationException(Configuration config, Throwable cause) {
        super(cause);
        this.config = config;
    }

    public Configuration getConfig() {
        return config;
    }
}
