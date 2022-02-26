package com.example.classroomiot.logic.utils.response;

import com.example.classroomiot.logic.dto.output.sqlcustom.UserOutPut;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Getter
@Setter
@Builder
public class PageList<T> implements List<UserOutPut> {
    private int currentPage;
    private int pageSize;
    private long total;
    private boolean success;
    private int totalPage;
    private List<T> list;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<UserOutPut> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(UserOutPut userOutPut) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends UserOutPut> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends UserOutPut> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public UserOutPut get(int i) {
        return null;
    }

    @Override
    public UserOutPut set(int i, UserOutPut userOutPut) {
        return null;
    }

    @Override
    public void add(int i, UserOutPut userOutPut) {

    }

    @Override
    public UserOutPut remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<UserOutPut> listIterator() {
        return null;
    }

    @Override
    public ListIterator<UserOutPut> listIterator(int i) {
        return null;
    }

    @Override
    public List<UserOutPut> subList(int i, int i1) {
        return null;
    }
}
