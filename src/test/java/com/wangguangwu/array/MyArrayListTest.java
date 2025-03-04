package com.wangguangwu.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        // 每个测试前都初始化一个新的 MyArrayList 实例
        list = new MyArrayList<>();
    }

    @AfterEach
    void after() {
        list.display();
    }

    @Test
    void testAddLast() {
        // 在末尾添加元素
        list.addLast(1);
        list.addLast(2);

        // 检查 size 是否正确
        assertEquals(2, list.size());

        // 检查元素是否正确添加
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testAddFirst() {
        // 在末尾添加元素
        list.addLast(1);

        // 在开头添加元素
        list.addFirst(0);

        // 检查 size 是否正确
        assertEquals(2, list.size());

        // 检查元素是否正确添加
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void testAddAtIndex() {
        // 添加元素
        list.addLast(1);
        list.addLast(3);

        // 在索引 1 位置插入元素 2
        list.add(1, 2);

        // 检查 size 是否正确
        assertEquals(3, list.size());

        // 检查各个位置的元素是否正确
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testRemoveLast() {
        // 添加元素
        list.addLast(1);
        list.addLast(2);

        // 删除最后一个元素并检查删除的元素
        assertEquals(2, list.removeLast());

        // 检查 size 是否正确
        assertEquals(1, list.size());

        // 检查剩余元素
        assertEquals(1, list.get(0));
    }

    @Test
    void testRemoveFirst() {
        // 添加元素
        list.addLast(1);
        list.addLast(2);

        // 删除第一个元素并检查删除的元素
        assertEquals(1, list.removeFirst());

        // 检查 size 是否正确
        assertEquals(1, list.size());

        // 检查剩余元素
        assertEquals(2, list.get(0));
    }

    @Test
    void testRemoveAtIndex() {
        // 添加元素
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        // 删除索引为 1 的元素并检查删除的元素
        assertEquals(2, list.remove(1));

        // 检查 size 是否正确
        assertEquals(2, list.size());

        // 检查剩余元素
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testSet() {
        // 添加元素
        list.addLast(1);
        list.addLast(2);

        // 修改索引为 1 的元素，并检查修改前的值
        assertEquals(2, list.set(1, 3));

        // 检查修改后的值
        assertEquals(3, list.get(1));
    }

    @Test
    void testGet() {
        // 添加元素
        list.addLast(1);
        list.addLast(2);

        // 测试获取指定索引的元素
        assertEquals(2, list.get(1));
    }

    @Test
    void testIsEmpty() {
        // 初始时列表为空
        assertTrue(list.isEmpty());

        // 添加元素后列表不应为空
        list.addLast(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testResize() {
        // 连续添加100个元素，测试扩容功能
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        // 检查 size 是否正确
        assertEquals(100, list.size());

        // 检查扩容后是否可以正确访问元素
        assertEquals(50, list.get(50));
    }

    @Test
    void testShrink() {
        // 添加100个元素
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        // 移除95个元素，测试缩容功能
        for (int i = 0; i < 95; i++) {
            list.removeLast();
        }

        // 检查 size 是否正确
        assertEquals(5, list.size());

        // 检查缩容后是否可以正确访问剩余元素
        assertEquals(4, list.get(4));
    }

    @Test
    void testOutOfBoundsException() {
        // 测试获取越界元素时是否抛出 IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        // 添加一个元素
        list.addLast(1);

        // 测试获取越界元素时是否抛出 IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));

        // 测试删除越界元素时是否抛出 IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }
}
