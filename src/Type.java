public enum Type {PERSONAL("Личная задача"), WORKTASK("Рабочая задача")
    ;
    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  getType() ;
    }
}
