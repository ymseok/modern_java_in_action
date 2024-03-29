package io.example.domain;

public class Apple {

    private Color color;
    private int weight;

    public Apple(Color color, int weight){
        this.color = color;
        this.weight = weight;
    }

    public Color getColor(){
        return color;
    }

    public int getWeight(){
        return weight;
    }

    public boolean isGreenApple(){
        return Color.GREEN.equals(color);
    }

    public boolean isHeavyApple(){
        return 100 < weight;
    }

    @Override
    public java.lang.String toString() {
        return String.format("Apple{color=%S, weight=%d",color.name(), weight);
    }
}
