package com.test.test.models;

public class Document {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // 1 2 3
    // 3 5 4
    //

    // 1 2 3 4 5
    //
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Document) {
            return this.getId() == ((Document) obj).getId();
        }
        return false;
    }
}
