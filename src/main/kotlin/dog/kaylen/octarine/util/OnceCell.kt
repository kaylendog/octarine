/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.util

import java.util.function.Supplier

/**
 * A one-time initializable cell.
 *
 * @param <T> The type stored in this cell.
</T> */
class OnceCell<T> {
    /** The internal value.  */
    private var inner: T? = null

    /**
     * Get the inner value.
     *
     * @return The inner value.
     */
    fun get(): T {
        if (inner == null) {
            throw NullPointerException("OnceCell has not been initialized")
        }
        return inner!!
    }

    /**
     * Get the inner value, or use a default.
     *
     * @param defaultValue The default value.
     * @return The inner or default value.
     */
    fun getOrDefault(defaultValue: T): T {
        return if (inner == null) {
            defaultValue
        } else {
            inner!!
        }
    }

    /**
     * Get the inner value, or use a default.
     *
     * @param defaultValue The default value.
     * @return The inner or default value.
     */
    fun getOrInit(defaultValue: T): T {
        if (inner == null) {
            this.set(defaultValue)
        }
        return inner
    }

    /**
     * Get the inner value, or initialize the cell with a default.
     *
     * @param executor An executor to run to generate the default value.
     * @return The inner or default value.
     */
    fun getOrInit(executor: Supplier<T>): T {
        if (inner == null) {
            this.set(executor.get())
        }
        return inner
    }

    /**
     * Set the value in this OnceCell.
     *
     * @param value The inner value.
     */
    fun set(value: T) {
        check(inner == null) { "OnceCell has already been initialized" }
        inner = value
    }
}
