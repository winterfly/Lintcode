class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        long value = 0;
        for (int i = 0; i < key.length; i++) {
            value = (value * 33 + (int)key[i]) % HASH_SIZE;
        }
        return (int)value;
    }
};
