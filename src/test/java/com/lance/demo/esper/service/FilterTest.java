package com.lance.demo.esper.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class FilterTest {
    Filter filter = new Filter();
    @Test
    public void filter() throws Exception {
        filter.filter();
    }

    @Test
    public void where() throws Exception {
        filter.where();
    }

}