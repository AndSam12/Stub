package Multimock.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("Item")
@Getter
@Setter
public class Item {
    @Id
    private String name;
    private String type;
    private String genre;

    public Item (String name, String type, String genre) {
        this.name = name;
        this.type = type;
        this.genre = genre;
    }
    public void setId(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setGenre(String genre) {
        this.name = genre;
    }


}
