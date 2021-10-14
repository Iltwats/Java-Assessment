/**
 * Generic interface to quantize any datatype passed into it
 *
 * @param <T>
 */
public interface Quantizer<T> {
    /**
     * Calculate quantized value of throttle
     *
     * @param quantity is passed as vehicle speed
     * @return the quantized value of throttle
     */
    T quantize(Integer quantity);
}
