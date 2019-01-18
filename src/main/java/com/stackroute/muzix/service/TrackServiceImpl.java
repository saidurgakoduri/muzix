package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.IdNotFoundException;
import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;
    @Autowired

    public TrackServiceImpl(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;
    }
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException
    {
        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistsException("track already exists");
        }


        Track savedTrack = trackRepository.save(track);
        if(savedTrack == null)
        {
            throw new TrackAlreadyExistsException(("track already exists"));
        }
            return savedTrack;
        }
        @Override
        public Track updateTrack(Track track) throws IdNotFoundException {
        if(trackRepository.existsById(track.getId())){
        throw new IdNotFoundException("Track id already exist");
    }
        Track updatedTrack=trackRepository.save(track);
        return updatedTrack;
    }
     @Override
        public boolean deleteTrack(int id) throws TrackNotFoundException {
        boolean status=false;
        if(trackRepository.existsById(id))
        {
            trackRepository.deleteById(id);
            status=true;
            return status;
        }
        else{
            throw new TrackNotFoundException("Track id not found");
        }
    }
    @Override
    public List<Track> getAllTracks()
    {
        return trackRepository.findAll();
    }



    }
