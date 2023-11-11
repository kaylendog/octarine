/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.proxy.Proxy

class Octarine(private val proxy: Proxy) {
    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: Octarine
        val PROXY: Proxy
            get() = INSTANCE.proxy
    }
}
