package Multimock.Sender;

public interface RedisService {
    void setValue(String key, String value);

    Object getValue(String key);
}