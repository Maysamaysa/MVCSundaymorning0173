//Model ตัวเก็บข้อมูล,ประมวลผลเช็คเงื่อนไข
public class suit {
    private String id;
    private String type;
    private int durability;

    public suit(String id, String type, int durability) {
        this.id = id;
        this.type = type;
        this.durability = durability;
    }
//getter setter ที่จำเป็น
    public String getId() { return id; }
    public String getType() { return type; }
    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }
//เงื่อนไขชุดผ่าน
    public boolean check() {
        if (type.equals("Power") && durability < 70) return false;//ทรงพลัง
        if (type.equals("Stealth") && durability < 50) return false;//ลอบเร้ย
        if (type.equals("Hide") && (durability % 10 == 3 || durability % 10 == 7)) return false;//ปกปิด
        return true;
    }
//ซ่อมไม่เกินร้อย
    public void repair() {
        if (durability < 100) {
            durability = Math.min(durability + 25, 100);
        }
    }
}
