package com.src.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class ClientCustomDetails implements ClientDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String clientId;
    private String clientSecret;
    private String scope;
    private String resourceServer;
    private String authorities;
    private String redirect_uri;
    private String authorized_grant_types;



    public ClientCustomDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ClientCustomDetails(String clientId, String clientSecret, String scope, String resourceServer,
            String authorities, String redirect_uri, String authorized_grant_types) {
        super();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scope = scope;
        this.resourceServer = resourceServer;
        this.authorities = authorities;
        this.redirect_uri = redirect_uri;
        this.authorized_grant_types = authorized_grant_types;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setResourceServer(String resourceServer) {
        this.resourceServer = resourceServer;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public void setAuthorized_grant_types(String authorized_grant_types) {
        this.authorized_grant_types = authorized_grant_types;
    }

    public Integer getAccessTokenValiditySeconds() {
        // TODO Auto-generated method stub
        return null;
    }

    public Map<String, Object> getAdditionalInformation() {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        Set<GrantedAuthority> listAuthorities = new HashSet<GrantedAuthority>();

        String[] auth = authorities.split(",");
        for(String element:auth) {
            SimpleGrantedAuthority grant = new SimpleGrantedAuthority(element);
            listAuthorities.add(grant);
        }

        return listAuthorities;
    }

    public Set<String> getAuthorizedGrantTypes() {
        // TODO Auto-generated method stub
        String[] list_grant_types = this.authorized_grant_types.split(",");
        Set<String> grant_types = new HashSet<String>();

        for(String element : list_grant_types) {
            grant_types.add(element);
        }

        return grant_types;
    }

    public String getClientId() {
        // TODO Auto-generated method stub
        return clientId;
    }

    public String getClientSecret() {
        // TODO Auto-generated method stub
        return clientSecret;
    }

    public Integer getRefreshTokenValiditySeconds() {
        // TODO Auto-generated method stub
        return null;
    }

    public Set<String> getRegisteredRedirectUri() {
        // TODO Auto-generated method stub
        String[] UriArray = this.redirect_uri.split(",");
        Set<String> Uries = new HashSet<String>();

        for(String element : UriArray) {
            Uries.add(element);
        }

        return Uries;
    }

    public Set<String> getResourceIds() {
        // TODO Auto-generated method stub
        String[] resourceArray = this.resourceServer.split(",");
        Set<String> resourceIds = new HashSet<String>();

        for(String element : resourceArray) {
            resourceIds.add(element);
        }

        return resourceIds;
    }

    public Set<String> getScope() {
        // TODO Auto-generated method stub
        String[] scopeArray = this.scope.split(",");
        Set<String> scope = new HashSet<String>();

        for(String scopeElement : scopeArray) {
            scope.add(scopeElement);
        }

        return scope;
    }

    public boolean isAutoApprove(String arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isScoped() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isSecretRequired() {
        // TODO Auto-generated method stub
        return false;
    }
//    private static final String DEFAULT_ROLE = "ROLE_USER";
//    private static final String[] authorized_grant_types =
//            {"password","authorization_code","refresh_token","implicit"};
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 1L;
//
//    private int accessTokenValiditySeconds;
//    private String client_id;
//    private String client_secret;
//    private String redirect_url;
//
//
//
//
//
//    @Override
//    public String toString() {
//        return "ClientCustomDetails [accessTokenValiditySeconds=" + accessTokenValiditySeconds + ", client_id="
//                + client_id + ", client_secret=" + client_secret + ", redirect_url=" + redirect_url + "]";
//    }
//
//    public ClientCustomDetails(int accessTokenValiditySeconds, String client_id, String client_secret,
//            String redirect_url) {
//        super();
//        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
//        this.client_id = client_id;
//        this.client_secret = client_secret;
//        this.redirect_url = redirect_url;
//    }
//
//    public String getClient_id() {
//        return client_id;
//    }
//
//    public void setClient_id(String client_id) {
//        this.client_id = client_id;
//    }
//
//    public String getClient_secret() {
//        return client_secret;
//    }
//
//    public void setClient_secret(String client_secret) {
//        this.client_secret = client_secret;
//    }
//
//    public String getRedirect_url() {
//        return redirect_url;
//    }
//
//    public void setRedirect_url(String redirect_url) {
//        this.redirect_url = redirect_url;
//    }
//
//    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
//        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
//    }
//
//    public Integer getAccessTokenValiditySeconds() {
//        // TODO Auto-generated method stub
//        return accessTokenValiditySeconds;
//    }
//
//    public Map<String, Object> getAdditionalInformation() {
//        // TODO Auto-generated method stub
//
//        return null;
//    }
//
//    public Collection<GrantedAuthority> getAuthorities() {
//        // TODO Auto-generated method stub
//        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority(DEFAULT_ROLE));
//
//        return authorities;
//    }
//
//    public Set<String> getAuthorizedGrantTypes() {
//        // TODO Auto-generated method stub
//        Set<String> authorizedGrantTypes=new HashSet<String>();
//        for(String granted: authorized_grant_types) {
//            authorizedGrantTypes.add(granted);
//        }
//        return authorizedGrantTypes;
//    }
//
//    public String getClientId() {
//        // TODO Auto-generated method stub
//        return client_id;
//    }
//
//    public String getClientSecret() {
//        // TODO Auto-generated method stub
//        return client_secret;
//    }
//
//    public Integer getRefreshTokenValiditySeconds() {
//        // TODO Auto-generated method stub
//        return accessTokenValiditySeconds;
//    }
//
//    public Set<String> getRegisteredRedirectUri() {
//        // TODO Auto-generated method stub
//        Set<String> callback = new HashSet<String>();
//        callback.add(redirect_url);
//        return callback;
//    }
//
//    public Set<String> getResourceIds() {
//        // TODO Auto-generated method stub
//        Set<String> reourseId = new HashSet<String>();
//        return reourseId;
//    }
//
//    public Set<String> getScope() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    public boolean isScoped() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    public boolean isSecretRequired() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    public boolean isAutoApprove(String arg0) {
//        // TODO Auto-generated method stub
//        return false;
//    }

}
