package com.wangguangwu.array;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 动态数组代码实现
 *
 * @author wangguangwu
 */
public class MyArrayList<E> {

    /**
     * 底层数组
     */
    private E[] data;

    /**
     * 当前元素个数
     */
    private int size;

    /**
     * 初始容量
     */
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    /**
     * 末尾新增元素
     *
     * @param e 元素
     */
    public void addLast(E e) {
        ensureCapacity();
        data[size++] = e;
    }

    /**
     * 根据索引新增元素
     *
     * @param index 索引位置
     * @param e     元素
     */
    public void add(int index, E e) {
        checkPositionIndex(index);
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    /**
     * 开头新增元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 删除元素
     *
     * @return 被删除的元素
     */
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        shrinkCapacity();
        E deletedVal = data[--size];
        // 避免内存泄漏
        data[size] = null;
        return deletedVal;
    }

    /**
     * 根据索引删除元素
     *
     * @param index 索引位置
     * @return 被删除的元素
     */
    public E remove(int index) {
        checkElementIndex(index);
        shrinkCapacity();
        E deletedVal = data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        // 避免内存泄漏
        data[--size] = null;
        return deletedVal;
    }

    /**
     * 删除第一个元素
     *
     * @return 第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 获取索引的对应的元素
     *
     * @param index 索引
     * @return 索引的对应的元素
     */
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    /**
     * 修改索引的对应的元素
     *
     * @param index   索引
     * @param element 新的元素
     * @return 索引的对应的元素
     */
    public E set(int index, E element) {
        checkElementIndex(index);
        E oldVal = data[index];
        data[index] = element;
        return oldVal;
    }

    // 工具方法
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 扩容/缩容数组
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }

    /**
     * 根据当前容量和元素数量自动缩容
     */
    private void shrinkCapacity() {
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
    }

    /**
     * 根据当前容量和元素数量自动扩容
     */
    private void ensureCapacity() {
        if (size == data.length) {
            resize(data.length == 0 ? INIT_CAP : data.length * 2);
        }
    }

    /**
     * 检查元素索引是否合法
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 检查位置索引是否合法
     */
    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }
}
