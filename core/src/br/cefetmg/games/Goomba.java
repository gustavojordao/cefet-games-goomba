/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Gustavo
 */
public class Goomba {
    
    //private Sprite sprite;
    
    private Vector2 position;
    
    private Animation moveUp;
    private Animation moveDown;
    private Animation moveRight;
    private Animation moveLeft;
    
    private Animation currentAnimation;
    
    private TextureRegion[][] frames;
    
    private float animationTime;
    
    private static final int WIDTH = 21;
    private static final int HEIGHT = 24;
        
    private static final float SPEED = 1;
    
    public Goomba(Texture texture){
        //sprite = new Sprite(texture);
        
        frames = TextureRegion.split(texture, WIDTH, HEIGHT);
        
        moveDown = new Animation(0.1f, frames[0]);
        moveDown.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        moveRight = new Animation(0.1f, frames[1]);
        moveRight.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        moveUp = new Animation(0.1f, frames[2]);
        moveUp.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        moveLeft = new Animation(0.1f, frames[3]);
        moveLeft.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        currentAnimation = moveDown;
        
        animationTime = 0.0f;
    }
    
    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            /*
            if(sprite.getY() + HEIGHT + SPEED <= Gdx.graphics.getHeight()){
                sprite.setY(sprite.getY() + SPEED);
            }
            */
            
            if(position.y + HEIGHT + SPEED <= Gdx.graphics.getHeight()){
                position.y += SPEED;
            }
            currentAnimation = moveUp;
        }
        
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            /*
            if(sprite.getY() - SPEED >= 0){
                sprite.setY(sprite.getY() - SPEED);
            }
            */

            if(position.y - SPEED >= 0){
                position.y -= SPEED;
            }
            
            currentAnimation = moveDown;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            /*
            if(sprite.getX() + WIDTH + SPEED <= Gdx.graphics.getWidth()){
                sprite.setX(sprite.getX() + SPEED);
            }
            */
            
            if(position.x + WIDTH + SPEED <= Gdx.graphics.getWidth()){
                position.x += SPEED;
            }
            
            currentAnimation = moveRight;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            /*
            if(sprite.getX() - SPEED >= 0){
                sprite.setX(sprite.getX() - SPEED);
            }
            */
            
            if(position.x - SPEED >= 0){
                position.x -= SPEED;
            }
            
            currentAnimation = moveLeft;
        }
    }
    
    public void render(SpriteBatch batch){
        
        animationTime += Gdx.graphics.getDeltaTime();
        
        //batch.draw((TextureRegion) currentAnimation.getKeyFrame(animationTime), sprite.getX(), sprite.getY());
        batch.draw((TextureRegion) currentAnimation.getKeyFrame(animationTime), position.x, position.y);
    }

    /*
    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    */

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
    
    public float getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(float animationTime) {
        this.animationTime = animationTime;
    }
    
}
