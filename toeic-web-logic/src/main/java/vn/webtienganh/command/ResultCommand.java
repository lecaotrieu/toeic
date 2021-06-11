package vn.webtienganh.command;

import vn.webtienganh.core.dto.ResultDTO;
import vn.webtienganh.core.web.command.AbstractCommand;

public class ResultCommand extends AbstractCommand<ResultDTO> {
    public ResultCommand() {
        this.pojo = new ResultDTO();
    }
}
