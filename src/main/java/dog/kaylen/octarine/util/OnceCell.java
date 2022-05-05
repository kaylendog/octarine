/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.util;

import java.util.function.Supplier;

/**
 * A one-time initializable cell.
 *
 * @param <T> The type stored in this cell.
 */
public class OnceCell<T> {
    /** The internal value. */
    private T inner;

    /**
     * Get the inner value.
     *
     * @return The inner value.
     */
    public T get() {
        if (this.inner == null) {
            throw new NullPointerException("OnceCell has not been initialized");
        }
        return this.inner;
    }

    /**
     * Get the inner value, or use a default.
     *
     * @param defaultValue The default value.
     * @return The inner or default value.
     */
    public T getOrDefault(T defaultValue) {
        if (this.inner == null) {
            return defaultValue;
        }
        return this.inner;
    }

    /**
     * Get the inner value, or use a default.
     *
     * @param defaultValue The default value.
     * @return The inner or default value.
     */
    public T getOrInit(T defaultValue) {
        if (this.inner == null) {
            this.set(defaultValue);
        }
        return this.inner;
    }

    /**
     * Get the inner value, or initialize the cell with a default.
     *
     * @param executor An executor to run to generate the default value.
     * @return The inner or default value.
     */
    public T getOrInit(Supplier<T> executor) {
        if (this.inner == null) {
            this.set(executor.get());
        }
        return this.inner;
    }

    /**
     * Set the value in this OnceCell.
     *
     * @param value The inner value.
     */
    public void set(T value) {
        if (this.inner != null) {
            throw new IllegalStateException("OnceCell has already been initialized");
        }
        this.inner = value;
    }
}
