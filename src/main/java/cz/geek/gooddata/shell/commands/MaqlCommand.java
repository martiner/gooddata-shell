package cz.geek.gooddata.shell.commands;

import cz.geek.gooddata.shell.components.GoodDataHolder;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 */
@Component
public class MaqlCommand extends AbstractGoodDataCommand {

    @Autowired
    public MaqlCommand(final GoodDataHolder holder) {
        super(holder);
    }

    @CliAvailabilityIndicator({"maql"})
    public boolean isAvailable() {
        return holder.hasCurrentProject();
    }


    @CliCommand(value = "maql", help = "Execute MAQL DDL")
    public String maql(@CliOption(key = {"maql", ""}, help = "MAQL DDL") String maql,
                       @CliOption(key = "file", help = "MAQL DDL file") File file) throws IOException {
        if (file != null) {
            final List<String> maqls = FileUtils.readLines(file);
            getGoodData().getModelService().updateProjectModel(getCurrentProject(), maqls).get();
        } else if (maql != null) {
            getGoodData().getModelService().updateProjectModel(getCurrentProject(), maql).get();
        } else {
            throw new IllegalArgumentException("maql or file argument has to be specified");
        }
        return "Executed";
    }

}
