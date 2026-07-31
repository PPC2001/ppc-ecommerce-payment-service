locals {
  name = "ppc-ecommerce-payment-service"
  environments = merge(var.task_definition.environments, {
    SPRING_PROFILES_ACTIVE = lower(var.environment_name)
    GIT_COMMIT_HASH        = var.git_commit_hash
    GIT_TAG_NAME           = var.git_tag_name
  })
  secrets = merge(var.task_definition.secrets, {})
  tags = merge(var.tags, {
    iac_source = local.name
  })
}
