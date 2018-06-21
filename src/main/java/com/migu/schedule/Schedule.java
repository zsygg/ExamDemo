package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;
import java.util.*;

import java.util.List;

/*
 *类名和方法不能修改
 */
public class Schedule {

    private List<Integer> Node = new ArrayList<Integer>();
    private Map<Integer, Integer> taskMap = new HashMap<Integer, Integer>();
    private Map<Integer, Integer> taskInfoMap = new HashMap<Integer, Integer>();
    private List<TaskInfo> tasks = new ArrayList<TaskInfo>();

    public TaskInfo[] taskInfolist(){
        TaskInfo[] taskInfolist = new TaskInfo[5];
        return taskInfolist;
    }
    public int init() {
        Node.clear();
        taskMap.clear();
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {

        if(nodeId <= 0){
            return ReturnCodeKeys.E004;
        }
        for(int i=0;i<Node.size();i++){
            int a = Node.get(i);//获取每一个Example对象
            if(a == nodeId){
                return ReturnCodeKeys.E005;
            }
        }
        Node.add(nodeId);
        return ReturnCodeKeys.E003;
    }

    public int unregisterNode(int nodeId) {
        for(int i=0;i<Node.size();i++){
            int a = Node.get(i);//获取每一个Example对象
            if(a == nodeId){
                Node.remove(i);
                return ReturnCodeKeys.E005;
            }
        }
        return ReturnCodeKeys.E007;
    }


    public int addTask(int taskId, int consumption) {
        if(taskId <= 0){
            return ReturnCodeKeys.E009;
        }
        for(Map.Entry<Integer,Integer> entry:taskMap.entrySet()){
            int key = entry.getKey();
            if(taskId == key){
                return ReturnCodeKeys.E010;
            }
        }
        taskMap.put(taskId,consumption);
        return ReturnCodeKeys.E008;
    }


    public int deleteTask(int taskId) {
        for(Map.Entry<Integer,Integer> entry:taskMap.entrySet()){
            int key = entry.getKey();
            if(taskId == key){
                taskMap.remove(taskId);
                return ReturnCodeKeys.E011;
            }
        }
        return ReturnCodeKeys.E012;
    }


    public int scheduleTask(int threshold) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }

    public static Map sortByComparator(Map unsortMap){
        List list = new LinkedList(unsortMap.entrySet());
// System.out.println("list:"+list);
        Collections.sort(list, new Comparator()
        {
            public int compare(Object o1, Object o2)
            {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        Map sortedMap = new LinkedHashMap();

        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;

    }

}
