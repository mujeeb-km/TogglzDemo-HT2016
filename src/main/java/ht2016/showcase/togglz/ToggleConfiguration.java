package ht2016.showcase.togglz;

import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author HT2016l;
 */
@ApplicationScoped
public class ToggleConfiguration implements TogglzConfig {

    public Class<? extends Feature> getFeatureClass() {
        return FeatureDefinition.class;
    }

    public StateRepository getStateRepository() {
        return new InMemoryStateRepository();
    }

    public UserProvider getUserProvider() {
        return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                return new SimpleFeatureUser("admin", true);
            }
        };
    }

}
