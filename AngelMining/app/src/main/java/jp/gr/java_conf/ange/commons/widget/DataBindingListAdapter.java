package jp.gr.java_conf.ange.commons.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * ListView Adapter for DataBinding Layout.
 */
public class DataBindingListAdapter<T> extends BaseAdapter {

    /**
     * Model List
     */
    private List<T> dataList;

    /**
     *  DataBindingUtil.inflate attachParent setting flag.
     */
    private boolean attachParent;

    /**
     * Generated ViewDataBinding Object
     */
    private ViewDataBinding binding;

    /**
     * ListView Layout Row ID
     */
    private int layoutId;

    /**
     * Generated BR ID.
     */
    private int variableId;

    /**
     * Context LayoutInflater
     */
    private LayoutInflater inflater;

    /**
     * Constructor
     *
     * @param context    context
     * @param layoutId   layout id
     * @param variableId generated databinding id
     * @param dataList   model list
     */
    public DataBindingListAdapter(@NonNull Context context, @LayoutRes int layoutId, int variableId, @Nullable List<T> dataList) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.setDataList((dataList != null) ? dataList : createDefaultDataList());
        this.setAttachParent(false);
    }

    public DataBindingListAdapter(@NonNull Context context, @LayoutRes int layoutId, int variableId) {
        this(context, layoutId, variableId, null);
    }

    protected List<T> createDefaultDataList() {
        return new LinkedList<T>();
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public T getItem(int position) {
        return getDataList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            binding = DataBindingUtil.inflate(inflater, layoutId, parent, isAttachParent());
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ViewDataBinding) convertView.getTag();
        }

        binding.setVariable(variableId, getItem(position));
        return convertView;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public boolean isAttachParent() {
        return attachParent;
    }

    public void setAttachParent(boolean attachParent) {
        this.attachParent = attachParent;
    }
}
