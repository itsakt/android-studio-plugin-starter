package com.akt.awesomeplugin;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@State(
        name = "StorageHelper",
        storages = {
                @Storage(
                        id = "awesomeplugin",
                        file = "awesomeplugin.xml")
        }
)
public class StorageHelper implements PersistentStateComponent<StorageHelper.State> {

    static class State {
        public String name = "";
    }

    private State mState = new State();

    @Nullable
    @Override
    public State getState() {
        return this.mState;
    }

    @Override
    public void loadState(State state) {
        XmlSerializerUtil.copyBean(state, this.mState);
    }

    public static StorageHelper getInstance() {
        return ServiceManager.getService(StorageHelper.class);
    }

    @Nullable
    public static StorageHelper getInstance(Project project) {
        return ServiceManager.getService(project, StorageHelper.class);
    }

}
