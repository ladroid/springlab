package com.lab.lado.dbconnect;

public class Books {
    private Integer id;
    private String name;
    private Integer pagecount;
    private Integer point;
    private Integer authorid;
    private Integer typeid;
    private String fragment;

    public Books() {}

    public Books(Integer id, String name, Integer pagecount, Integer point, Integer authorid, Integer typeid) {
        this.id = id;
        this.name = name;
        this.pagecount = pagecount;
        this.point = point;
        this.authorid = authorid;
        this.typeid = typeid;
    }

    public static class BuilderBooks {
        private Integer id;
        private String name;
        private Integer pagecount;
        private Integer point;
        private Integer authorid;
        private Integer typeid;
        private String fragment;

        public BuilderBooks setId(Integer id) {
            this.id = id;
            return this;
        }

        public BuilderBooks setName(String name) {
            this.name = name;
            return this;
        }

        public BuilderBooks setPagecount(Integer pagecount) {
            this.pagecount = pagecount;
            return this;
        }

        public BuilderBooks setPoint(Integer point) {
            this.point = point;
            return this;
        }

        public BuilderBooks setAuthorid(Integer authorid) {
            this.authorid = authorid;
            return this;
        }

        public BuilderBooks setTypeid(Integer typeid) {
            this.typeid = typeid;
            return this;
        }

        public BuilderBooks setFragment(String fragment) {
            this.fragment = fragment;
            return this;
        }

        public Books build() {
            return new Books(id, name, pagecount, point, authorid, typeid);
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPagecount(Integer pagecount) {
        this.pagecount = pagecount;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPagecount() {
        return pagecount;
    }

    public Integer getPoint() {
        return point;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public String getFragment() {
        return fragment;
    }
}
