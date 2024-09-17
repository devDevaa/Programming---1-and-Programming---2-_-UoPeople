package com.studentmanagementsystem.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class GridLayout implements LayoutManager {

    public GridLayout(int i, int j) {
    }

    public GridLayout() {
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        throw new UnsupportedOperationException("Unimplemented method 'addLayoutComponent'");
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        throw new UnsupportedOperationException("Unimplemented method 'removeLayoutComponent'");
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Unimplemented method 'preferredLayoutSize'");
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Unimplemented method 'minimumLayoutSize'");
    }

    @Override
    public void layoutContainer(Container parent) {
        throw new UnsupportedOperationException("Unimplemented method 'layoutContainer'");
    }

}
