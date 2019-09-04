package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    static class Entry<T> implements Serializable {
        String elementName;
        Entry<T> parent, leftChild, rightChild;
        boolean availableToAddLeftChildren, availableToAddRightChildren, deleted;
        int size;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
            deleted = false;
            size = 1;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public void setAsDeleted() {
            deleted = true;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    Entry<String> root;

    public CustomTree() {
        root = new Entry<>("root");
        root.setSize(0);
    }

    public String getParent(String s) {
        String parentName = null;

        try {
            Entry<String> node = root;
            Queue<Entry<String>> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                if (queue.peek().leftChild != null && !queue.peek().leftChild.deleted) {
                    queue.add(queue.peek().leftChild);
                }

                if (queue.peek().rightChild != null && !queue.peek().rightChild.deleted) {
                    queue.add(queue.peek().rightChild);
                }

                node = queue.poll();
                if (node.elementName.equals(s)) {
                    parentName = node.parent.elementName;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parentName;
    }

    @Override
    public boolean add(String s) {
        boolean flag = false;

        try {
            Entry<String> node = root;
            Queue<Entry<String>> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                if (queue.peek().leftChild != null && !queue.peek().leftChild.deleted) {
                    queue.add(queue.peek().leftChild);
                }

                if (queue.peek().rightChild != null && !queue.peek().rightChild.deleted) {
                    queue.add(queue.peek().rightChild);
                }

                node = queue.poll();
                if (node.isAvailableToAddChildren() || node.leftChild.deleted && node.rightChild.deleted) break;
            }

            if (node.leftChild == null || node.leftChild.deleted) {
                node.leftChild = new Entry<>(s);
                node.leftChild.parent = node;
                node.availableToAddLeftChildren = false;
                node = node.leftChild;
                while ((node = node.parent) != null) {
                    node.setSize(node.size + 1);
                }
                flag = true;
            } else if (node.rightChild == null || node.rightChild.deleted) {
                node.rightChild = new Entry<>(s);
                node.rightChild.parent = node;
                node.availableToAddRightChildren = false;
                node = node.rightChild;
                while ((node = node.parent) != null) {
                    node.setSize(node.size + 1);
                }
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean remove(Object o) {
        boolean flag = false;

        try {
            if (!(o instanceof String)) throw new UnsupportedOperationException();

            Entry<String> node = root;
            Queue<Entry<String>> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                if (queue.peek().leftChild != null && !queue.peek().leftChild.deleted) {
                    queue.add(queue.peek().leftChild);
                }

                if (queue.peek().rightChild != null && !queue.peek().rightChild.deleted) {
                    queue.add(queue.peek().rightChild);
                }

                node = queue.poll();
                if (node.elementName.equals(o)) {
                    node.setAsDeleted();
                    int deletedSubTreeSize = node.size;
                    while ((node = node.parent) != null) {
                        node.setSize(node.size - deletedSubTreeSize);
                    }
                    flag = true;
                    break;
                }
            }
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public int size() {
        return root.size;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}
