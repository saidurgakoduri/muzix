package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.IdNotFoundException;
import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;

import java.util.List;

public  interface TrackService {
    public Track saveTrack(Track track) throws  TrackAlreadyExistsException;
    public List<Track> getAllTracks();
    public boolean deleteTrack(int id) throws TrackNotFoundException;
    public Track updateTrack(Track track) throws IdNotFoundException;
}

