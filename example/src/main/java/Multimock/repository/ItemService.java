package Multimock.repository;

import Multimock.model.Item;

public interface ItemService {
    void saveItem(Item item);

    Item getItem(String name);
}
