package com.example.ai.helper;

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition,int toPosition);

    void onItemDismiss(int position);

}
