package org.verifier;

public interface StateVerifier {

    /**
     * Verifies whether container state is similar
     * to state stored in application log.
     *
     * @param name container name
     * @return true when state is valid, false otherwise
     */
    boolean check(String name);
}
