package com.example.imagegallery.config;

public class Path {
    ///////////////////////////////////////////////////////////////
    // URL BASE
    ///////////////////////////////////////////////////////////////

    public static final String URL_BASE = "https://api.flickr.com/services/rest/";

    ///////////////////////////////////////////////////////////////
    // ROUT SEARCH AND GET_SIZE
    ///////////////////////////////////////////////////////////////
    public static final String SEARCH = "?method=flickr.photos.search&api_key=9a95c68a9c6ec61104cd3967dcbb8bd3&tags=kitten&page=1&format=json&nojsoncallback=1";
    public static final String GET_SIZE = "?method=flickr.photos.getSizes&api_key=9a95c68a9c6ec61104cd3967dcbb8bd3&photo_id=31456463045&format=json&nojsoncallback=1";

}
