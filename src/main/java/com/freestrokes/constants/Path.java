package com.freestrokes.constants;

public class Path {

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Prefix
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    // API Prefix
    public static final String API = "/api/v1";

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Common
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

//    public static final String HEALTH = API + "/health-check";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Attach
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Auth
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String AUTHS = API;
//    public static final String AUTHS_REDIRECT = AUTHS + "/redirect";
//    public static final String AUTHS_USER = AUTHS + "/user";
//    public static final String AUTHS_USER_ME = AUTHS + "/user/me";
//    public static final String AUTHS_FAIL = AUTHS + "/fail";
//    public static final String AUTHS_LOGOUT = AUTHS + "/logout";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| USER
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String USERS = API + "/users";
//    public static final String USER_DETAIL = USERS+ "/user";
//    public static final String USER_AUTH_DETAIL = USERS+ "/auth-detail";
//    public static final String USERS_AUTH_REQUEST = USERS + "/auth-request";
//    public static final String USERS_APPROVED= USERS + "/approved";
//    public static final String USERS_ACTIVATED = USERS + "/activated";
//    public static final String USERS_ROLES = USERS + "/roles";
//    public static final String USERS_MANAGER = USERS_ROLES + "/manager/{id}";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| ROLE
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String ROLES = API + "/roles";
//    public static final String ROLE = ROLES + "/{id}";
//    public static final String ROLE_MENU = ROLE + "/menu";
//    public static final String ROLE_CONTENTES_RESOURCES = ROLE + "/contents-resources";
//    public static final String ROLE_BOTS = ROLE + "/bots";
//    public static final String ROLE_USERS = ROLE + "/users";
//    public static final String ROLE_HISTORY = ROLE + "/history";
//
//    public static final String ROLES_NAME = ROLES + "/name";
//    public static final String ROLES_TEMPLATES = ROLES + "/templates";
//    public static final String ROLES_TEMPLATES_MENU = ROLES + "/templates/menu";
//    public static final String ROLES_USERS = ROLES + "/users";
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Menu
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String MENUS = API + "/menus";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Mp Product
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String MP_PRODUCTS = API + "/mp-products";
//    public static final String MP_PRODUCT = MP_PRODUCTS + "/{id}";
//    public static final String MP_PRODUCT_NAME_DUPLICATION_CHECK = MP_PRODUCTS + "/mp-product-name-check/duplication";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Mp Product Review
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String MP_PRODUCT_REVIEWS = API + "/mp-product-reviews";
//    public static final String MP_PRODUCT_REVIEW = MP_PRODUCT_REVIEWS + "/{id}";
//    public static final String MP_PRODUCT_REVIEW_VM = MP_PRODUCT_REVIEWS + "/{id}/vm-files";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Mp Product Modify
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String MP_PRODUCT_MODIFIES = API + "/mp-product-modifies";
//    public static final String MP_PRODUCT_MODIFY = MP_PRODUCT_MODIFIES + "/{id}";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Mp Product Category
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String MP_PRODUCT_CATEGORIES = API + "/mp-product-categories";
//    public static final String MP_PRODUCT_ALL_CATEGORIES = API + "/mp-product-all-categories";
//    public static final String MP_PRODUCT_CATEGORY = MP_PRODUCT_CATEGORIES + "/{id}";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Mp Product History
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String MP_PRODUCT_HISTORIES = API + "/mp-product-histories";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Mp Product Status
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String MP_PRODUCT_STATUSES = API + "/mp-product-statuses";
//    public static final String MP_PRODUCT_STATUS = MP_PRODUCT_STATUSES + "/{id}";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Board
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String BOARDS = API + "/boards";
//    public static final String BOARD_WAIT = API + "/boards/wait_num";
//    public static final String BOARD = BOARDS + "/{id}";
//    public static final String COMMENT = API + "/comment";
//    public static final String DEL_COMMENT = COMMENT + "/{id}";
//    public static final String ANSWER_FLAG = API + "/board/status";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| File
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String FILES = API + "/files";
//    public static final String FILE = FILES + "/{id}";
//    public static final String GET_FILE = FILE + "/download";
//
//    public static final String GET_SETTLEMENT_FILE = FILES + "/settlement";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Machine File
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String VM_FILES = API + "/vm-files";
//    public static final String VM_FILE = VM_FILES + "/{id}";
//    public static final String VM_MANAGER_FILES = API + "/vm-manager-files";
//    public static final String VM_MP_PRODUCT_FILES = API + "/vm-mp-product-files";
//    public static final String GET_VM_FILE = VM_FILE + "/download";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Contract
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String SALES = API + "/sales";
//    public static final String SALE = SALES + "/{id}";
//    public static final String CONTRACT = API + "/contract/{id}";
//    public static final String CONTRACT_SUSPENSION = API + "/contract/suspension/{id}";
//    public static final String CONFIRM_CONTRACT = API + "/contract/confirm/{id}";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Settlement
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String SETTLEMENTS = API + "/settlements";
//    public static final String SETTLEMENT = SETTLEMENTS + "/{id}";
//    public static final String SETTLEMENTS_DATA = API + "/settlements-data";
//    public static final String SETTLEMENTS_ALL_DATA = API + "/settlements-all-data";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Cloud Metering
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String METERING = API + "/metering";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| VM Flavor
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String VM_FLAVORS = API + "/vm-flavors";
//    public static final String VM_ALL_FLAVORS = API + "/vm-flavors-all";
//    public static final String VM_FLAVOR = VM_FLAVORS + "/{id}";
//    public static final String VM_FLAVOR_SYNCHRONIZATION = API + "/vm-flavors-synchronization";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Base OS
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String BASE_OSES = API + "/base-os";
//
//    public static final String BASE_OS = BASE_OSES + "/{id}";
//
//    public static final String BASE_OS_ALL = API + "/base-os-all";
//
//    public static final String BASE_OS_DUPLICATION = BASE_OSES + "/duplication";
//
//    public static final String BASE_OS_BTS_PRODUCT = BASE_OSES + "/bts-product/{id}";
//
//    public static final String BASE_OS_VERSIONS = API + "/base-os-versions";
//
//    public static final String BASE_OS_VERSION = BASE_OS_VERSIONS + "/{id}";
//
//    public static final String BASE_OS_VERSION_USED = BASE_OS_VERSION + "/used";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Openstack
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String OPENSTACK_FLAVORS = API + "/openstack-flavors";
//    public static final String OPENSTACK_RETRY_UPLOAD_MANUAL = API + "/openstack-retry-upload-manual/{id}";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Partner
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String PARTNER = API + "/management/partner";
//    public static final String PARTNER_LIST = PARTNER + "/list";
//    public static final String PARTNER_DETAIL = PARTNER + "/{partnerId}/detail";
//    public static final String PARTNER_ADD = PARTNER + "/add";
//    public static final String PARTNER_MARKET_ADD = PARTNER + "/add/market/{partnerId}";
//    public static final String PARTNER_UPDATE = PARTNER + "/{partnerId}/update";
//    public static final String PARTNER_REG_NUMBER_VALIDATION_CHECK = PARTNER + "/reg-number-check/validation/{regNumber}";
//    public static final String PARTNER_REG_NUMBER_DUPLICATION_CHECK = PARTNER + "/reg-number-check/duplication/{regNumber}";
//    public static final String PARTNER_LIST_ALL = PARTNER + "/list/all";
//    public static final String PARTNER_LIST_ALL_CHECK_ADMIN = PARTNER + "/list/all/check-admin";
//
//    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| marketplace-server API
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//    public static final String KIC_API = API + "/kic";
//    public static final String KIC_CLIENT = KIC_API + "/client";
//    public static final String KIC_CLIENT_LOGIN = KIC_CLIENT + "/login";
//    public static final String KIC_CLIENT_SIGNUP = KIC_CLIENT + "/signup";
//    public static final String KIC_TEST = KIC_API + "/test";
//    public static final String KIC_CONTRACTS = KIC_API + "/contracts";
//    public static final String KIC_CONTRACT = KIC_CONTRACTS + "/{id}";
//    public static final String KIC_CONTRACT_EXPERT =  KIC_API + "/contract/expert";
//    public static final String KIC_FILE = KIC_API + "/file/{id}";
//    public static final String KIC_FILE_DOWNLOAD = KIC_FILE + "/download";
//    public static final String KIC_EXTERNAL = KIC_API + "/external";
//    public static final String KIC_FLAVOR = KIC_API + "/flavors";
//    public static final String KIC_OPEN_LIST = KIC_API + "/products";
//    public static final String KIC_OPEN_DETAIL = KIC_OPEN_LIST + "/{id}";
//    public static final String KIC_OPEN_PRODUCT_ID = KIC_API + "/image/product";
//    public static final String KIC_MP_PRODUCTS = KIC_API + "/mp-products";
//    public static final String KIC_MP_PRODUCT = KIC_MP_PRODUCTS + "/{id}";
//    public static final String KIC_MP_PRODUCT_INFO =  KIC_API + "/mp-product-info";
//    public static final String KIC_MP_PRODUCT_ALL_CATEGORIES = KIC_API + "/mp-product-all-categories";
//    public static final String KIC_SUPPORTS = KIC_API + "/supports";
//    public static final String KIC_SUPPORTS_WAIT = KIC_API + "/supports/wait";
//    public static final String KIC_SUPPORT = KIC_SUPPORTS + "/{id}";
//    public static final String KIC_COMMENT = KIC_SUPPORTS +"/comment";
//    public static final String KIC_DELETE_COMMENT = KIC_COMMENT + "/{id}";

}
