package com.example.demoset.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lenovo on 2017/4/10.
 */

public class ExpandableBean implements Serializable{
    private String parentName = "";
    private int parentId = 0;
    private ArrayList<Child> childList = new ArrayList<>();

    public static class Child {
        private String childName = "";
        private int childId= 0;
        private int type = 0;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }

        public int getChildId() {
            return childId;
        }

        public void setChildId(int childId) {
            this.childId = childId;
        }
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public ArrayList<Child> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<Child> childList) {
        this.childList = childList;
    }
}
