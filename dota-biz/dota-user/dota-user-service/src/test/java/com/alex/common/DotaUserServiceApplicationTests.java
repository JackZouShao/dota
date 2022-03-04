package com.alex.common;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RunWith(JUnit4.class)
class DotaUserServiceApplicationTests {

    private List<Track> trackList;

    @BeforeEach
    public void beforeTest(){
        trackList = new ArrayList<>(16);
        trackList.add(new Track("Tom", 11));
        trackList.add(new Track("Tom2",12));
        trackList.add(new Track("Tom3",13));
        trackList.add(new Track("Tom4",14));
    }


    @Test
    void contextLoads() {
        Track track = trackList.stream().min(Comparator.comparing(Track::getName).reversed()).get();

        System.out.println(track);
        trackList.stream().sorted().forEach(System.out::println);

        // reduce 求和
        System.out.println(trackList.stream().reduce( (t1, t2) -> t1.setLength(t1.getLength() + t2.getLength())));
    }


    public static void main(String[] args) {

        ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(()-> new SimpleDateFormat());
        DateFormat dateFormat = threadLocal.get();
        System.out.println(dateFormat);
    }
}
