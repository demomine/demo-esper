package com.lance.demo.esper.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessTest {
    Process process = new Process();
    @Test
    public void insertStream() throws Exception {
        process.insertStream();
    }

    @Test
    public void removeStream() throws Exception {
        process.removeStream();
    }

    @Test
    public void iremoveStream() throws Exception {
        process.iremoveStream();
    }

}