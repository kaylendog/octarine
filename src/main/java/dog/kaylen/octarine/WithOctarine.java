/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine;

import org.slf4j.Logger;

public interface WithOctarine {
    /**
     * @return A reference to the plugin singleton.
     */
    default OctarineMod getInstance() {
        return OctarineMod.INSTANCE;
    }

    /**
     * @return A reference to the plugin logger.
     */
    default Logger getLogger() {
        return this.getInstance().LOGGER;
    }
}
