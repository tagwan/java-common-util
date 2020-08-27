package io.github.ai.behaviortree;

import io.github.ai.behaviortree.ifs.IBehaviour;

/**
 * 行为树是一种树状的数据结构，树上的每一个节点都是一个行为。
 * 每次调用会从根节点开始遍历，通过检查行为的执行状态来执行不同的节点。
 * 他的优点是耦合度低扩展性强，每个行为可以与其他行为完全独立。
 * 目前的行为树已经可以将几乎任意架构（如规划器，效用论等）应用于AI之上。
 */
public class BehaviorTree {
    private IBehaviour root;

    public BehaviorTree(IBehaviour root) {
        this.root = root;
    }

    public void tick() {
        root.tick();
    }

    public boolean haveRoot() {
        return root != null ? true : false;
    }

    public void setRoot(IBehaviour inNode) {
        root = inNode;
    }

    public void release() {
        root.release();
    }
}
/**
 上面提供了行为树的实现，行为树有一个根节点和一个Tick（）方法，
 在游戏过程中每个一段时间会调用依次Tick方法，
 令行为树从根节点开始执行。**/