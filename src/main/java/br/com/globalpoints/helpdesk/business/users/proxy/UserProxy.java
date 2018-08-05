package br.com.globalpoints.helpdesk.business.users.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.globalpoints.helpdesk.business.users.entities.UserHelpDesk;
import br.com.globalpoints.sharedkernel.api.response.ApiReturn;

@FeignClient(name = "userProxy", url = "${api.users}/user")
public interface UserProxy {
    @PostMapping("auth/helpdesk")
    ApiReturn<UserHelpDesk> helpDeskUserAuth(String login, String password);
}
