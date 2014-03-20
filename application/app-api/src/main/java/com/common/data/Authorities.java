package com.common.data;


public enum Authorities {
    ROLE_ANONYMOUS(0, "ROLE_ANONYMOUS"),
    ROLE_USER(1, "ROLE_USER"),
    ROLE_ADMIN(2, "ROLE_ADMIN");

    private int id;
    private String name;

    private Authorities(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Authorities getAuthoritiesById(int id){
        for(Authorities authorities: Authorities.values()){
            if(id== authorities.getId()){
                return authorities;
            }
        }
        return null;
    }

    public static Authorities getAuthoritiesByName(String name){
        for(Authorities authorities: Authorities.values()){
            if(name.equalsIgnoreCase(authorities.getName())){
                return authorities;
            }
        }
        return null;
    }
}
