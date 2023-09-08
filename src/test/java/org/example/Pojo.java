package org.example;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = FirstPojo.class, name = "FIRST")})
public class Pojo {
  public AssetType type;
}
