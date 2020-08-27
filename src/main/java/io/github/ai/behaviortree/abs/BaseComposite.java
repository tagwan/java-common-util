package io.github.ai.behaviortree.abs;

import io.github.ai.behaviortree.ifs.IBehaviour;
import io.github.ai.behaviortree.ifs.IComposite;
import java.util.ArrayList;
import java.util.List;

/**
 * 我们将行为树中具有多个子节点的行为称为复合节点，
 * 通过复合节点我们可以将简单节点组合为更有趣更复杂的行为逻辑。
 *
 * 下面实现了一个符合节点的基类，将一些公用的方法放在了里面（如添加清除子节点等）
 *
 */
public abstract class BaseComposite extends BaseBehavior implements IComposite {

    protected ArrayList<IBehaviour> children = new ArrayList<>();

    @Override
    public void addChild(IBehaviour child) {
        children.add(child);
    }

    @Override
    public void removeChild(IBehaviour child) {
        children.remove(child);
    }

    @Override
    public void clearChild() {
        children.clear();
    }

    @Override
    public List<IBehaviour> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<IBehaviour> behaviours) {
        this.children = (ArrayList<IBehaviour>) behaviours;
    }
}
