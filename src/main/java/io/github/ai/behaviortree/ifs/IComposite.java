package io.github.ai.behaviortree.ifs;

import java.util.List;

/**
 * 组合节点
 */
public interface IComposite extends IBehaviour {

    void addChild(IBehaviour child);

    void removeChild(IBehaviour child);

    void clearChild();

    List<IBehaviour> getChildren();

    void setChildren(List<IBehaviour> behaviours);
}
