package com.example.rentalcar.demo.DTO;

public class Type {
    private String TypeName;
    private String TypeDescription;

    public Type(String typeName, String typeDescription) {
        TypeName = typeName;
        TypeDescription = typeDescription;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public String getTypeDescription() {
        return TypeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        TypeDescription = typeDescription;
    }
}
