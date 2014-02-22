package verii.movie_assistant.model;

import java.io.Serializable;

public interface EntityItem<T> extends Serializable {
    
    public T getId();
    
}
