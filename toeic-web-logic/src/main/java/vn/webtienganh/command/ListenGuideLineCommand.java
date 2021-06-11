package vn.webtienganh.command;

import vn.webtienganh.core.dto.ListenGuideLineDTO;
import vn.webtienganh.core.web.command.AbstractCommand;

public class ListenGuideLineCommand extends AbstractCommand<ListenGuideLineDTO> {
    public ListenGuideLineCommand() {
        this.pojo = new ListenGuideLineDTO();
    }
}
